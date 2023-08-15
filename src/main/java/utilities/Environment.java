package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:environmentConfig/${envName}.properties"})
public interface Environment extends Config{
	@Key("app.url")
	String appUrl();
	
	@Key("app.username")
	String appUsername();
	
	@Key("app.password")
	String appPassword();
	
	@Key("db.host")
	String dbHost();
	
	@Key("db.username")
	String dbUsername();
	
	@Key("db.password")
	String dbPassword();
}
