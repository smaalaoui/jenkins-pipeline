pipeline {

    agent { label 'jenkins-slave' }

    triggers { cron('* * * * *') }

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

        stage('Build') {
            steps {
                sh """
                    mkdir build
                    cp src/index.js build
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
