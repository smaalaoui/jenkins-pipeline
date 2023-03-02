pipeline {

    agent { label 'jenkins-slave' }

    stages {

        stage('Build') {
            steps {
                sh """
                    mkdir build
                    cp src/index.jp build
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
        }

    }

}