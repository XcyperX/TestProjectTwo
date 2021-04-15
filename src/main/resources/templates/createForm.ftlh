<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container">
        <button type="button" class="btn btn-primary btn-block mt-3 mb-3" onclick="submitNewForm()">Создать анкету
        </button>
        <div id="createForm">
            <input type="text" class="form-control" id="user_id" name="user_id" value="${user.id}" hidden>
            <div class="card mb-2">
                <div class="card-body">
                    <div>
                        <h4>Название анкеты</h4>
                        <input type="text" class="form-control" id="name_form" name="name_form" placeholder="Введите название анкеты">
                    </div>
                </div>
            </div>
            <div id="question">
                <div class="card card_question mb-2">
                    <div class="card-body">
                        <div class="row mb-3">
                            <div class="col-auto">
                                <h4>Тип вопроса:</h4>
                            </div>
                            <div class="col-auto">
                                <select id="some" name="some" class="form-control">
                                    <option value="true">Несколько ответов</option>
                                    <option value="false">Один ответ</option>
                                </select>
                            </div>
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" id="question_text" name="question_text" placeholder="Введите вопрос">
                        </div>
                        <hr>
                        <div class="answers mb-3">
                            <div class="row mb-2">
                                <div class="col">
                                    <input type="text" class="form-control answer_text" id="answer_text" name="answer_text"
                                           placeholder="Введите ответ">
                                </div>
                                <div class="col-auto">
                                    <button type="button" class="btn btn-primary" onclick="deleteSelf(this)">Удалить
                                        ответ
                                    </button>
                                </div>
                            </div>
                        </div>
                        <button type="button" class="btn btn-primary" onclick="addAnswer(this)">Добавить ответ</button>
                        <button type="button" class="btn btn-primary" onclick="removeQuestion(this)">Удалить вопрос
                        </button>
                    </div>
                </div>
            </div>
            <button type="button" class="btn btn-primary btn-block mt-3 mb-4" onclick="addQuestion()">Добавить вопрос
            </button>
        </div>
    </div>
</@c.page>