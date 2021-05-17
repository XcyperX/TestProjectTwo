<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <div class="row g-3 align-items-center">
            <div class="col-auto">
                <h3>Список анкет</h3>
            </div>
            <div class="col-auto">
                <a type="button" href="/users/forms" class="btn btn-primary mt-3 mb-3">Мои анкеты
                </a>
            </div>
        </div>
            <div class="list-group">
                <#list forms as form>
                    <div class="row">
                        <a href="/forms/${form.id?c}" class="list-group-item list-group-item-action">
                            ${form.nameForm}
                        </a>
                    </div>
                </#list>
            </div>
    </div>
</@c.page>