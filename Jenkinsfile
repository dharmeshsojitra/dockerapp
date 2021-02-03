node {
  def app

  stage('Clone repository') {
    /* Cloning the Repository to our Workspace */
    checkout scm
  }
  stage('Build') {
    git url: 'https://github.com/cyrille-leclerc/multi-module-maven-project'
    withMaven {
      sh "mvn clean install"
    } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
  }

  stage('Build image') {
    /* This builds the actual image */
    app = docker.build("dharmeshsojitra/dockerapp")

  }

  stage('Test image') {
    app.inside {
      echo "Tests passed"
    }
  }

  stage('Push image') {
    /* 
    	You would need to first register with DockerHub before you can push images to your account
    */
    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-groovy') {
      app.push("${env.BUILD_NUMBER}")
      app.push("latest")
    }
    echo "Trying to Push Docker Build to DockerHub"
  }
}
