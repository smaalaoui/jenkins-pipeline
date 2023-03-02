pipeline {

    agent { label 'master' }

    tools {
        maven "maven-3.6.0"
    }

    stages {

        stage('Clean') {
            steps {
                deleteDir()
            }
        }

        stage('Clone') {
            steps {
                checkout scm
            }
        }

        stage('TU') {
            steps {
                sh """
                    mvn clean test
                """
            }
        }

        /*stage('Build') {
            steps {
                sh """
                    mvn clean package
                """
            }
        }

        stage('Staging') {
            steps {
                sh "echo Staging"
            }
        }

        stage('Deploy') {
            steps {
                sh "echo Deployment"
            }
        }*/

    }

    post {
        failure {
            sh "echo failure occurred"
        }

        success {
            sh "echo Succeeded"
        }

        always {
            sh "echo Job finished"
        }
    }

}
