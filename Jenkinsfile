def HOST_IP = "54.154.198.55"
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

        stage('Build') {
            steps {
                sh """
                    mvn clean package
                """
            }
        }

        stage('Deploy & Run App') {
            steps {
                script {
                    sshagent(credentials: ['my-key-pair']) {
                        sh """
                            scp -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null .scripts/01-undeploy.sh ubuntu@${HOST_IP}:/home/ubuntu
                            scp -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null .scripts/02-deploy.sh ubuntu@${HOST_IP}:/home/ubuntu
                            scp -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null target/app.jar ubuntu@${HOST_IP}:/home/ubuntu
                            ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null ubuntu@${HOST_IP} "chmod +x /home/ubuntu/01-undeploy.sh /home/ubuntu/02-deploy.sh"
                            ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null ubuntu@${HOST_IP} "/home/ubuntu/01-undeploy.sh"
                            ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null ubuntu@${HOST_IP} "/home/ubuntu/02-deploy.sh"
                        """
                    }
                }
            }
        }

        stage('API Test') {
            steps {
                sh "newman run .postman/api_test_staging.json"
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
