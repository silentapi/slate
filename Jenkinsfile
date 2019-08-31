pipeline {
	agent any
	
	stages {
		stage("Build") {
			steps {
				sh "./gradlew build"
			}
		}
		stage("Unit Test") {
			steps {
				sh "./gradlew test"
			}
		}
	}
}