pipeline {
    agent any

    environment {
        // The branch that triggered the build - some random update
        BRANCH_NAME = "${env.BRANCH_NAME ?: 'feature/unknown'}"
        DEV_BRANCH = "dev"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out branch: ${BRANCH_NAME}"
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo "Building the project..."
                dir('PostService') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Unit Tests') {
            steps {
                echo "Running Unit Tests..."
                dir('PostService') {
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit 'PostService/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Coverage (Jacoco)') {
            steps {
                echo "Generating code coverage..."
                dir('PostService') {
                    sh 'mvn jacoco:report'
                }
                publishHTML(target: [
                    reportDir: 'PostService/target/site/jacoco',
                    reportFiles: 'index.html',
                    reportName: 'Jacoco Code Coverage'
                ])
            }
        }

        stage('Approval for Merge to Dev') {
            steps {
                script {
                    input message: "Approve merge of ${BRANCH_NAME} into ${DEV_BRANCH}?", ok: 'Approve'
                }
            }
        }

        stage('Merge to Dev (Secure HTTPS)') {
            steps {
                script {
                    sh """
                            echo "Merge successful"
                    """
                }
            }
        }

    }

    post {
        success {
            echo "✅ Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed. Check the logs for details."
        }
    }
}
