<#import "common.ftlh" as c>
<#macro formPage form user source=true>
    <div class="container">
    <div id="createForm">
        <div id="name_form">
            <h3>${form.nameForm}</h3>
        </div>
        <div id="question">
            <#list form.questionDTOList as question>
                <div class="card card_question mb-2">
                    <div class="card-body">
                        <input type="text" class="form-control" id="some" name="some"
                               value="<#if question.some>true<#else>false</#if>" hidden>
                        <label class="form-check-label" for="flexCheckDefault" id="question_text"
                               name="question_text">
                            ${question.text}
                        </label>
                        <div class="ml-3">
                            <#if question.some>
                                <div class="answers">
                                    <#list question.answers as answer>
                                        <div class="form-check">
                                            <input class="form-check-input answer_check" type="checkbox" value="false"
                                                   id="answer_check" onclick="testCheck(this)"
                                                   name="answer_question_${question.id?c}"
                                                   <#if !source && answer.choice>checked</#if>
                                            <label class="form-check-label" id="answer_text">
                                                ${answer.text}
                                            </label>
                                        </div>
                                    </#list>
                                </div>
                            <#else>
                                <div class="answers">
                                    <#list question.answers as answer>
                                        <div class="form-check">
                                            <input class="form-check-input answer_check" type="radio" value="false"
                                                   <#if !source && answer.choice>checked</#if>
                                                   id="answer_check" onclick="checkRadioButton(this)"
                                                   name="answer_question_${question.id?c}">
                                            <label class="form-check-label" id="answer_check">
                                                ${answer.text}
                                            </label>
                                        </div>
                                    </#list>
                                </div>
                            </#if>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
        <#if source>
            <button type="button" class="btn btn-primary mb-5" onclick="submitDoneForm(${form.id?c}, ${user.id?c})">Завершить
                анкетирование
            </button>
        </#if>
    </div>
</#macro>