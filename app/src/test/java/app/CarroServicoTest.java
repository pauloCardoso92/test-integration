package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.teste.app.model.Carro;
import br.teste.app.servico.CarroServico;

@RunWith(Arquillian.class)
public class CarroServicoTest {

    @Deployment
    public static Archive<WebArchive> createDeployment() {
        File[] files = Maven.configureResolver().workOffline().loadPomFromFile("pom.xml")
                .importRuntimeAndTestDependencies().resolve().withTransitivity().asFile();

        WebArchive deployment = ShrinkWrap.create(WebArchive.class, "app.war");
        deployment.addPackage(Carro.class.getPackage());
        deployment.addPackage(CarroServico.class.getPackage());
        deployment.addAsLibraries(files);
        deployment.addAsWebInfResource(new File("src/test/resources/web.xml"));
        
        System.out.println(deployment.toString(true));
        
        return deployment;
    }

    @Test
    public void deveRetornarCarro() throws IOException {
        URL url = new URL("http://172.25.141.49:8081/app/app-servico/carro/155");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        conn.disconnect();
    }

}
