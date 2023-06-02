package org.eijsink.injection.complex.cloud;

import org.eijsink.injection.complex.annotation.SpringAnnotation;

@SpringAnnotation
public class CloudService {

    public void callAzureService(){
        System.out.println("Calling AzureService");
    }

}
