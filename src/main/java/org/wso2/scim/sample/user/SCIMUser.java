/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License
 */

package org.wso2.scim.sample.user;

import org.wso2.charon.core.attributes.ComplexAttribute;
import org.wso2.charon.core.attributes.SimpleAttribute;
import org.wso2.charon.core.exceptions.CharonException;

public class SCIMUser extends org.wso2.charon.core.objects.User {

    private static final String DATE_OF_BIRTH = "dateOfBirth";
    private static final String COUNTRY = "country";

    private ComplexAttribute wso2extension;

    public SCIMUser(){
        super();
    }

    private synchronized ComplexAttribute getWso2ExtensionAttribute(){
        if(wso2extension != null){
            return wso2extension;
        }else{
            wso2extension = new ComplexAttribute("wso2Extension");
            return wso2extension;
        }
    }

    private synchronized void setWso2ExtensionAttribute(){
        setAttribute(wso2extension);
    }

    public void setDateOfBirth(String dateOfBirth) throws CharonException {
       SimpleAttribute atr = new SimpleAttribute(DATE_OF_BIRTH, dateOfBirth);
      // ComplexAttribute atr2 = new ComplexAttribute("wso2Extension");
      // atr2.setSubAttribute(atr);
       getWso2ExtensionAttribute().setSubAttribute(atr);
       setWso2ExtensionAttribute();
    }

    public void setCountry(String Country) throws CharonException {
        SimpleAttribute atr = new SimpleAttribute(COUNTRY, Country);
//        ComplexAttribute atr2 = new ComplexAttribute("wso2Extension");
//        atr2.setSubAttribute(atr);
//        setAttribute(atr2);
//        wso2extension.setSubAttribute(atr);
//        setAttribute(wso2extension);
        getWso2ExtensionAttribute().setSubAttribute(atr);
        setWso2ExtensionAttribute();
    }

}
