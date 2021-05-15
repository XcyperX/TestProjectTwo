<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
<div class="container">
    <div class="row g-3 align-items-center mb-3">
        <div class="col-auto">
            <a type="button" class="btn btn-primary" href="api/pdf/users">Создать отчет по пользователям системы
            </a>
        </div>
        <div class="col-auto">
            <button type="button" class="btn btn-primary" data-toggle="modal"
                    data-target="#createProvider">
                Регистрация
            </button>
            <!-- Modal -->
            <div class="modal fade" id="createProvider" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-md">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Регистрация</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <@l.login user="" create=true />
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                            <button type="button" class="btn btn-primary"
                                    onclick="submitNewUser()">Регистрация
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Отчество</th>
            <th scope="col">Роль</th>
            <th scope="col"></th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.secondName}</td>
            <td>
                <#list roles?values as role>
                    <#if role == user.role>
                        ${role.getNameRole()}
                    </#if>
                </#list>
            </td>
            <td>
                <button type="button" class="btn btn-primary" data-toggle="modal"
                        data-target="#user_${user.id}">
                    Список анкет
                </button>
                <!-- Modal -->
                <div class="modal fade" id="user_${user.id}" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Список анкет пользователя ${user.lastName} ${user.firstName} ${user.secondName}</h5>
                            </div>
                            <div class="modal-body">
                                <div class="container">
                                    <div class="list-group">
                                        <#list forms as form>
                                            <#if form.user.id == user.id>
                                            <div class="row">
                                                <a href="/forms/${form.id}" class="list-group-item list-group-item-action">
                                                    ${form.nameForm}
                                                </a>
                                            </div>
                                            </#if>
                                        </#list>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>
                <button type="button" class="btn btn-warning" data-toggle="modal"
                        data-target="#update_${user.id}">
                    Изменить
                </button>
                <!-- Modal -->
                <div class="modal fade" id="update_${user.id}" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-md">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Редактирование ${user.lastName} ${user.firstName} ${user.secondName}</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <@l.login user=user create=false />
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                                <button type="button" class="btn btn-primary"
                                        onclick="submitUpdateUser(this)">Сохранить изменения
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>
                <button type="button" class="btn btn-danger" onclick="deleteUserById(${user.id})">Удалить
                </button>
            </td>
            </tr>
        </#list>
        </table>
    </div>
</@c.page>