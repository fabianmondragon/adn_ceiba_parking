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
                sh 'chmod u+x gradlew'
                sh './gradlew clean'
            }
        }

        stage('Compile & Unit Tests') {
            steps{
                echo "------------>Compile & Unit Tests<------------"
                sh './gradlew --b ./app/build.gradle test jacocoTestReport'
                //sh './gradlew --b ./app/build.gradle androidTest'
            }
        }

        stage('Build') {
            steps {
                echo "------------>Build<------------"
                //Construir sin tarea test que se ejecutó previamente
                sh './gradlew --b ./app/build.gradle build -x test'
            }
        }

        stage('Static Code Analysis') {
            steps{
                echo '------------>Analisis de código estático<------------'
                withSonarQubeEnv('Sonar') {
                    sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
                }
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
