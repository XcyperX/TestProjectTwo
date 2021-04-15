<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <h3>Список анкет</h3>
            <div class="list-group">
                <#list forms as form>
                    <div class="row">
                        <a href="/forms/${form.id}" class="list-group-item list-group-item-action">
                            ${form.nameForm}
                        </a>
                    </div>
                </#list>
            </div>
    </div>
</@c.page>