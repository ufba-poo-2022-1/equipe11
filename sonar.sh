ant
sonar-scanner \
  -Dsonar.organization=ufba-poo-2022-1 \
  -Dsonar.projectKey=ufba-poo-2022-1_equipe11 \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.sources=Villagers \
	-Dsonar.java.binaries=Villagers/bin
