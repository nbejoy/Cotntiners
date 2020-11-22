package sample12.sample12;

import java.util.Iterator;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	//DefaultDockerClientConfig
    	
    	 DefaultDockerClientConfig config=DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost("tcp://127.0.0.1:2375").build();
    	  DockerClient client= DockerClientBuilder.getInstance(config).build();
    	  System.out.println(client.versionCmd());
    	  client.createContainerCmd("redis");
    	  
    	 //Listing and Iterating through containers 
    	 List<Container> containers=client.listContainersCmd().withShowAll(true).exec();
    	
    	Iterator<Container> it=containers.iterator();
    	
    	while(it.hasNext())
    	{ Container container= it.next();
    	System.out.println(container.getImage()+"="+container.getStatus());

    	}
    	
    	//client.startContainerCmd(containers.get(0).getId()).exec();
    	 //client.stopContainerCmd(containers.get(4).getId()).exec();
    		}

    	
    }
