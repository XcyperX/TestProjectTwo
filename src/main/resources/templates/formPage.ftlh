<#import "parts/common.ftlh" as c>
<#import "parts/formPage.ftlh" as fp>
<@c.page>
    <@fp.formPage user=user form=form/>
<#--    <div class="container">-->
<#--    <div id="createForm">-->
<#--        <div id="name_form">-->
<#--            <h3>${form.nameForm}</h3>-->
<#--        </div>-->
<#--        <div id="question">-->
<#--            <#list form.questionDTOList as question>-->
<#--                <div class="card card_question mb-2">-->
<#--                    <div class="card-body">-->
<#--                        <input type="text" class="form-control" id="some" name="some"-->
<#--                               value="<#if question.some>true<#else>false</#if>" hidden>-->
<#--                        <label class="form-check-label" for="flexCheckDefault" id="question_text"-->
<#--                               name="question_text">-->
<#--                            ${question.text}-->
<#--                        </label>-->
<#--                        <div class="ml-3">-->
<#--                            <#if question.some>-->
<#--                                <div class="answers">-->
<#--                                    <#list question.answers as answer>-->
<#--                                        <div class="form-check">-->
<#--                                            <input class="form-check-input answer_check" type="checkbox" value=""-->
<#--                                                   id="answer_check" onclick="testCheck(this)" name="answer_question_${question.id}">-->
<#--                                            <label class="form-check-label" id="answer_text">-->
<#--                                                ${answer.text}-->
<#--                                            </label>-->
<#--                                        </div>-->
<#--                                    </#list>-->
<#--                                </div>-->
<#--                            <#else>-->
<#--                                <div class="answers">-->
<#--                                    <#list question.answers as answer>-->
<#--                                        <div class="form-check">-->
<#--                                            <input class="form-check-input answer_check" type="radio"-->
<#--                                                   id="answer_check" onclick="checkRadioButton(this)" name="answer_question_${question.id}">-->
<#--                                            <label class="form-check-label" id="answer_check">-->
<#--                                                ${answer.text}-->
<#--                                            </label>-->
<#--                                        </div>-->
<#--                                    </#list>-->
<#--                                </div>-->
<#--                            </#if>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </div>-->
<#--            </#list>-->
<#--        </div>-->
<#--        <button type="button" class="btn btn-primary" onclick="submitDoneForm(${form.id}, ${user.id})">Завершить анкетирование-->
<#--        </button>-->
<#--    </div>-->
</@c.page>