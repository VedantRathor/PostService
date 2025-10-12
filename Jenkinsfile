pipeline {
    agent any

    environment {
        // The branch that triggered the build
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
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Unit Tests') {
            steps {
                echo "Running Unit Tests..."
                sh 'mvn test'
            }
            post {
                always {
                    echo "Publishing JUnit test reports..."
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Coverage (Jacoco)') {
            steps {
                echo "Running Jacoco Code Coverage..."
                sh 'mvn jacoco:report'
            }
            post {
                always {
                    echo "Archiving Jacoco reports..."
                    archiveArtifacts artifacts: '**/target/site/jacoco/**', fingerprint: true
                }
            }
        }

        stage('Static Code Analysis (SonarQube placeholder)') {
            steps {
                echo "Running SonarQube / static code analysis..."
                sh 'echo "SonarQube analysis placeholder" > target/sonar-report.txt'
                archiveArtifacts artifacts: 'target/sonar-report.txt', fingerprint: true
            }
        }

        stage('Approval for Merge to Dev') {
            steps {
                script {
                    input message: "Approve merge of ${BRANCH_NAME} into ${DEV_BRANCH}?", ok: 'Approve'
                }
            }
        }

        stage('Merge to Dev (Simulated)') {
            steps {
                script {
                    echo "Merging ${BRANCH_NAME} into ${DEV_BRANCH}..."
                    // Make sure Git credentials are configured in Jenkins
                    sh """
                        git checkout ${DEV_BRANCH}
                        git pull origin ${DEV_BRANCH}
                        git merge --no-ff ${BRANCH_NAME} -m "Merge ${BRANCH_NAME} into ${DEV_BRANCH}"
                        git push origin ${DEV_BRANCH}
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

