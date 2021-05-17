<#import "parts/common.ftlh" as c>
<#import "parts/formPage.ftlh" as fp>
<@c.page>
<div class="container">
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Название анкеты</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list forms as form>
        <tr>
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
                                <div class="container">
                                    <div class="list-group">
                                        <@fp.formPage user="" form=form source=false/>
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
    <button type="button" class="btn btn-danger" onclick="deleteFormById(${form.id?c})">Удалить
    </button>
</td>
</tr>
</#list>
</table>
</div>
</@c.page>