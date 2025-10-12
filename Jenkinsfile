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

