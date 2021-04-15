<#macro login user create=true>
    <div class="container pl-2 pr-2">
        <div class="row">
            <div class="col">
                <#if create>
                    <div id="createUser">
                <#else>
                    <div id="updateUser">
                </#if>
                    <div class="form-row mb-2">
                        <div class="col pl-0">
                            <input id="first_name" type="text" name="first_name" class="form-control" placeholder="Имя"
                                   value="<#if user?has_content>${user.firstName}</#if>">
                        </div>
                        <div class="col">
                            <input id="last_name" type="text" name="last_name" class="form-control"
                                   placeholder="Фамилия"
                                   value="<#if user?has_content>${user.lastName}</#if>">
                        </div>
                        <div class="col pr-0">
                            <input id="second_name" type="text" name="second_name" class="form-control"
                                   placeholder="Отчество"
                                   value="<#if user?has_content>${user.secondName}</#if>">
                        </div>
                    </div>
                    <div class="form-row mb-2">
                        <div class="col pl-0">
                            <input id="login" type="text" name="login" class="form-control"
                                   placeholder="Логин"
                                   value="<#if user?has_content>${user.login}</#if>">
                        </div>
                        <div class="col pr-0">
                            <input id="password" type="text" name="password" class="form-control"
                                   placeholder="Пароль"
                                   value="<#if user?has_content>${user.password}</#if>">
                        </div>

                    </div>
                    <div class="form-row mb-2">
                        <div class="col pl-0 pr-0">
                            <label>Выберите роль</label>
                            <select id="role" class="form-control">
                                <#list roles?values as role>
                                    <#if user?has_content>
                                        <#if role.getNameRole() == user.role>
                                            <option value="${role}"
                                                    selected>${role.getNameRole()}</option>
                                        <#else>
                                            <option value="${role}">${role.getNameRole()}</option>
                                        </#if>
                                    <#else>
                                        <option value="${role}">${role.getNameRole()}</option>
                                    </#if>
                                </#list>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</#macro>

