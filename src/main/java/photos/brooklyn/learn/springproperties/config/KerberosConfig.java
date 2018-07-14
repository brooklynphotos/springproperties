package photos.brooklyn.learn.springproperties.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kerberos")
public class KerberosConfig {
    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getKeytab() {
        return keytab;
    }

    public void setKeytab(String keytab) {
        this.keytab = keytab;
    }

    public String getKrb() {
        return krb;
    }

    public void setKrb(String krb) {
        this.krb = krb;
    }

    private String principal;
    private String keytab;
    private String krb;
}
