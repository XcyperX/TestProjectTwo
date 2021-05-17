<#import "parts/common.ftlh" as c>
<#import "parts/formPage.ftlh" as fp>

<@c.page>
<a type="button" class="btn btn-secondary mb-3" href="/api/pdf/passed/forms" data-dismiss="modal">Создать отчет пройденных анкет
</a>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Отчество</th>
            <th scope="col">Название анкеты</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list forms as form>
            <tr>
                <#list users as user>
                    <#if form.user.id == user.id>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.secondName}</td>
                    </#if>
                </#list>
                <td>${form.nameForm}</td>
                <td>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#form_${form.id?c}">
                        Подробности
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="form_${form.id?c}" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-body">
                                    <#list users as user>
                                        <#if form.user.id == user.id>
                                            <@fp.formPage user=user form=form source=false/>
                                        </#if>
                                    </#list>
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
                    <button type="button" class="btn btn-danger" onclick="deleteFormById(${form.id?c})">Удалить
                    </button>
                </td>
            </tr>
        </#list>
    </table>
</@c.page>