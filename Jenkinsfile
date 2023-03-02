pipeline {

    agent { label 'jenkins-slave' }

    stages {

        stage('Build') {
            steps {
                sh "echo Building"
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
        }

    }

}