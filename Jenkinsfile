pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('PMD Analysis') {
            steps {
                sh 'mvn pmd:check'
            }
        }

        stage('Deploy to Staging') {
            when {
                branch 'main'
            }
            steps {
                script {
                    try {
                        sh 'docker build -t myapp:${GIT_COMMIT} .'
                        sh 'kubectl apply -f k8s/deployment.yaml'
                    } catch (Exception e) {
                        echo "Falha no deploy. Iniciando rollback automático..."
                        sh 'kubectl rollout undo deployment/myapp-deployment'
                        error("Deploy falhou! Rollback executado: ${e.getMessage()}")
                    }
                }
            }
        }
    }

    post {
        failure {
            echo "Build Failed: ${env.JOB_NAME}"
        }
    }
}