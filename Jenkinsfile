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
                dir('PostService') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        // stage('Unit Tests') {
        //     steps {
        //         echo "Running Unit Tests..."
        //         dir('PostService') {
        //             sh 'mvn test'
        //         }
        //     }
        //     post {
        //         always {
        //             junit 'PostService/target/surefire-reports/*.xml'
        //         }
        //     }
        // }

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
stage('Merge to Dev (Secure)') {
    steps {
        script {
            withCredentials([usernamePassword(credentialsId: 'creds',
                                             usernameVariable: 'GIT_USER',
                                             passwordVariable: 'GIT_TOKEN')]) {

                // Use double-quotes for Groovy interpolation of BRANCH_NAME
                sh """
                    set -e  # Exit on any error

                    echo "Cleaning workspace..."
                    rm -rf PostService

                    echo "Cloning repository securely..."
                    git clone https://\$GIT_USER:\$GIT_TOKEN@github.com/VedantRathor/PostService.git
                    cd PostService

                    # Configure Git identity
                    git config user.name "Jenkins CI"
                    git config user.email "jenkins@example.com"

                    # Checkout dev branch
                    git checkout dev
                    git pull origin dev

                    # Fetch feature branch safely
                    git fetch origin "${BRANCH_NAME}:${BRANCH_NAME}"

                    # Merge feature branch into dev
                    if git merge --no-ff "${BRANCH_NAME}" -m "Merge ${BRANCH_NAME} into dev"; then
                        echo "Merge successful"
                    else
                        echo "Merge failed due to conflicts. Resolve manually."
                        exit 1
                    fi

                    # Push merged dev branch
                    git push origin dev
                """
            }
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

