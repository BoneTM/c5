node {
    def dockerName = 'c5'
    def dockerTag = 'dev'

    stage('Pull Git') {
        git credentialsId: '3447caab-7b38-4f40-8056-fb980fe73986', url: 'https://github.com/BoneTM/c5.git'
    }

    stage('Maven Build') {
        docker.image('maven:3.6.0-jdk-8-alpine').inside('-u root -v /data/maven:/root/.m2') {
            sh 'mvn --version'
            sh 'mvn clean package'
        }
    }

    stage('Docker Build') {
        def name = "${dockerName}:${dockerTag}"
        sh "docker rm -f ${dockerName} || echo 'container does not exist'"
        sh "docker rmi ${name} || echo 'images does not exist'"
        def customImage = docker.build(name)
        customImage.run("-it -d --name ${dockerName} -p 9999:9999")
    }
}