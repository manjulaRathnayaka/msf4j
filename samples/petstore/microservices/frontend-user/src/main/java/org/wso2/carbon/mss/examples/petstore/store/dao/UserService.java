/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.wso2.carbon.mss.examples.petstore.store.dao;

import org.wso2.carbon.mss.examples.petstore.store.model.User;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@ManagedBean
@ApplicationScoped
public class UserService implements Serializable {

    private static Map<String, User> users = new HashMap<>();

    public boolean authenticate(String username, String password) {
        if (username != null && password != null & !username.isEmpty() && !password.isEmpty()) {
            User current = findUser(username);
            if (current != null) {
                if (current.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User findUser(String username) {
        return users.get(username);
    }
}
