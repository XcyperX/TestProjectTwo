
<#macro listPassedForms users forms>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Отчество</th>
            <th scope="col">Название анкеты</th>
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
                            data-target="#form_${form.id}">
                        Подробности
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="form_${form.id}" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-body">
                                    <#if isCustomer>
                                        <@cc.employee employees=employee/>
                                    <#else>
                                        <@ce.employee employees=employee subdivisions=subdivisions positionsNames=positionsNames />
                                    </#if>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </#list>
    </table>
</#macro>

