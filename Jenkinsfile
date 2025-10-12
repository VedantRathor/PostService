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

        stage('Merge to Dev (Simulated)') {
            steps {
                script {
                    echo "Merging ${BRANCH_NAME} into dev..."
        
                    sh '''
                        git config user.name "Jenkins CI"
                        git config user.email "jenkins@example.com"
                    '''
        
                    sh 'git checkout dev'
                    sh 'git pull origin dev'
                    sh "git fetch origin ${BRANCH_NAME}:${BRANCH_NAME}"
        
                    sh """
                        if git merge --no-ff ${BRANCH_NAME} -m 'Merge ${BRANCH_NAME} into dev'; then
                            echo "Merge successful"
                        else
                            echo "Merge failed or conflicts detected. Resolve manually."
                        fi
                    """
        
                    // Push inside credentials block
                    withCredentials([usernamePassword(credentialsId: '0b436d1b-d405-4ab2-8335-41894b51e430', 
                                                     usernameVariable: 'GIT_USER', 
                                                     passwordVariable: 'GIT_TOKEN')]) {
                        sh '''
                            echo "Configuring remote..."
                            git remote set-url origin https://$GIT_USER:$GIT_TOKEN@github.com/VedantRathor/PostService.git
                            git push origin dev
                        '''
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

