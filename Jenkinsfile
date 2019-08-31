pipeline {
	agent {
		image 'gradle:latest' 
        args '-v /root/.gradle:/root/.gradle' 
	}
	
	stages {
		stage("Compile") {
			steps {
				sh "./gradlew compileJava"
			}
		}
		stage("Unit Test") {
			steps {
				sh "./gradlew test"
			}
		}
		stage("Deliver") {
			steps {
				sh "./gradlew bootJar"
			}
		}
	}
}