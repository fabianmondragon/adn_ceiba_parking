pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave4_Mac'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  //tools {
  //  jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
  //  gradle 'Gradle4.5_Centos' //Preinstalada en la Configuración del Master
 // }
  tools {
      jdk 'JDK8_Mac'
    }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
         echo "------------>Checkout<------------"
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    gitTool: 'Default',
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        url:'https://github.com/fabianmondragon/adn_ceiba_parking'
                    ]]
                ])
      }
    }

    stage('Compile & Unit Tests') {
          steps{
            echo "------------>Unit Tests<------------"
             sh 'chmod u+x gradlew'
             sh './gradlew clean jacocoTestReport'
            //sh './gradlew --b ./app/build.gradle jacocoTestReport'
            sh './gradlew --b ./app/build.gradle test'
           // sh './gradlew --b ./app/build.gradle androidTest'

          }
        }

        stage('Static Code Analysis') {
          steps{
            echo '------------>Analisis de codigo estatico<------------'
           withSonarQubeEnv('Sonar') {
           sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
           }
          }
        }

        stage('Build') {
          steps {
            echo "------------>Build<------------"
            //Construir sin tarea test que se ejecutó previamente
            sh 'chmod u+x gradlew'
           // sh './gradlew clean'
            sh './gradlew --b ./app/build.gradle build -x test'

          }
        }
      }

      post {
        always {
          echo 'This will always run'
        }
        success {
          echo 'This will run only if successful'
        //junit 'app/build/test-results/testDebugUnitTest/*.xml'
        }
        failure {
          echo 'This will run only if failed'
          mail (to: 'fabian.mondragon@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
         }
        unstable {
          echo 'This will run only if the run was marked as unstable'
        }
        changed {
          echo 'This will run only if the state of the Pipeline has changed'
          echo 'For example, if the Pipeline was previously failing but is now successful'
        }
      }
}
