submitNewUser = (user_id) => {
    let legacyUser;
    if (user_id == null) {
        legacyUser = document.getElementById("createUser");
    } else {
        legacyUser = document.getElementById("updateUser_" + user_id);
        user.user_id = user_id;
    }
    user.first_name = legacyUser.querySelector("#first_name").value;
    user.last_name = legacyUser.querySelector("#last_name").value;
    user.second_name = legacyUser.querySelector("#second_name").value;
    user.role = legacyUser.querySelector("#role").value;
    user.password = legacyUser.querySelector("#password").value;
    user.login = legacyUser.querySelector("#login").value;

    console.log(user);
    if (user_id != null) {
        updateUserById(user_id, user);
    } else {
        createNewUser(user);
    }
}

submitNewForm = (form_id) => {
    let legacyForm;
    if (form_id == null) {
        legacyForm = document.getElementById("createForm");
    } else {
        legacyForm = document.getElementById("updateForm_" + form_id);
        form.form_id = form_id;
    }

    form.name_form = legacyForm.querySelector("#name_form").value;
    user.user_id = legacyForm.querySelector("#user_id").value;
    form.user = JSON.parse(JSON.stringify(user));
    form.source = true;
    let questionList = legacyForm.getElementsByClassName("card_question");
    console.log(questionList);
    for (let i = 0; i < questionList.length; i++) {
        question.some = questionList[i].querySelector("#some").value;
        question.text = questionList[i].querySelector("#question_text").value;
        let answerList = questionList[i].getElementsByClassName("answers")[0];
        console.log(answerList);
        for (let j = 0; j < answerList.getElementsByClassName("answer_text").length; j++) {
            console.log(answerList.getElementsByClassName("answer_text")[j].value);
            answer.text = answerList.getElementsByClassName("answer_text")[j].value;
            question.answers_list.push(JSON.parse(JSON.stringify(answer)));
        }
        form.questions_list.push(JSON.parse(JSON.stringify(question)))
        question.answers_list = [];
    }
    console.log(form);
    createNewForm(form);
}

submitDoneForm = (form_id, user_id) => {
    getFormById(form_id).then(form => {
        let legacyForm = document.getElementById("createForm");
        let questionList = legacyForm.getElementsByClassName("card_question");
        for (let i = 0; i < questionList.length; i++) {
            let answerList = questionList[i].getElementsByClassName("answers")[0];
            form.questions_list[i].question_id = null;
            form.questions_list[i].form_id = null;
            for (let j = 0; j < answerList.getElementsByClassName("answer_check").length; j++) {
                console.log(form.questions_list[i].answers_list[j].choice);
                form.questions_list[i].answers_list[j].choice = answerList.getElementsByClassName("answer_check")[j].value;
                form.questions_list[i].answers_list[j].answer_id = null;
                form.questions_list[i].answers_list[j].questions_id = null;
            }
        }
        user.user_id = user_id;
        form.form_id = null;
        form.source = false;
        form.user = JSON.parse(JSON.stringify(user));
        // console.log(form);
        createNewForm(form);
    })

}

const user = {
    user_id: null,
    first_name: null,
    last_name: null,
    second_name: null,
    password: null,
    role: null,
    login: null
}

const form = {
    form_id: null,
    name_form: null,
    user: null,
    source: null,
    questions_list: []
}

const question = {
    some: null,
    text: null,
    answers_list: []
}

const answer = {
    choice: false,
    text: null
}

sendRequest = (method, url, body) => {
    const headers = {
        'Content-Type': 'application/json'
    }
    if (body !== null) {
        return fetch(url, {
            method: method,
            body: JSON.stringify(body),
            headers: headers
        });
    } else {
        return fetch(url, {
            method: method,
            headers: headers
        });
    }
}

sendRequestWithFile = (method, url, body) => {
    const headers = {}
    console.log(body);
    if (body !== null) {
        return fetch(url, {
            method: method,
            body: body,
            headers: headers
        });
    } else {
        return fetch(url, {
            method: method,
            headers: headers
        });
    }
}

getUsers = (user_id) => {
    return sendRequest('GET', '/api/users/' + user_id, null).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            console.log(response);
        }
    });
}

getFormById = (form_id) => {
    return sendRequest('GET', '/api/forms/' + form_id, null).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            console.log(response);
        }
    });
}

createNewForm = (form) => {
    sendRequest('POST', '/api/forms', form).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.href = "http://localhost:8080/forms";
            alert("Готово! )");
        } else {
            console.log(response);
        }
    });

}

createNewUser = (user) => {
    sendRequest('POST', '/api/registrations', user).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

updateUserById = (user_id, user) => {
    sendRequest('PUT', '/api/users/' + user_id, user).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.href = "http://localhost:8080/users";
        } else {
            console.log(response);
        }
    });
}

deleteUserById = (user_id) => {
    sendRequest('DELETE', '/api/users/' + user_id).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

function deleteSelf(button) {
    button.parentNode.parentNode.remove();
}

function addAnswer(button) {
    let answer = `<div class="row mb-2">
                            <div class="col">
                                <input type="text" class="form-control answer_text" id="answer_text" name="answer_text" placeholder="Введите ответ">
                            </div>
                            <div class="col-auto">
                                <button type="button" class="btn btn-primary" onclick="deleteSelf(this)">Удалить ответ</button>
                            </div>
                        </div>`
    answer = document.createRange().createContextualFragment(answer);
    button.parentNode.getElementsByClassName("answers")[0].appendChild(answer);
}

function addQuestion() {
    let questionList = document.getElementById("question");
    let questionForm = `<div class="card card_question mb-2">
                <div class="card-body">
                    <div class="row mb-3">
                        <div class="col-auto">
                            <h4>Тип вопроса:</h4>
                        </div>
                        <div class="col-auto">
                            <select id="some" class="form-control">
                                <option value="true">Несколько ответов</option>
                                <option value="false">Один ответ</option>
                            </select>
                        </div>
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control" id="question_text"  name="question_text" placeholder="Введите вопрос">
                    </div>
                    <hr>
                    <div class="answers mb-3">
                        <div class="row mb-2">
                            <div class="col">
                                <input type="text" class="form-control answer_text" id="answer_text"  name="answer_text" placeholder="Введите ответ">
                            </div>
                            <div class="col-auto">
                                <button type="button" class="btn btn-primary" onclick="deleteSelf(this)">Удалить ответ</button>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="addAnswer(this)">Добавить ответ</button>
                    <button type="button" class="btn btn-primary" onclick="removeQuestion(this)">Удалить вопрос</button>
                </div>
            </div>`
    questionForm = document.createRange().createContextualFragment(questionForm);
    questionList.appendChild(questionForm);
}

function removeQuestion(button) {
    button.parentNode.parentNode.remove();
}

function testCheck(elem) {
    if (elem.checked) {
        elem.setAttribute("value", "true");
    } else {
        elem.setAttribute("value", "false");
    }
}

function checkRadioButton(elem) {
    let button = elem.parentNode.parentNode;
    for (let i = 0; i < button.getElementsByClassName("answer_check").length; i++) {
        button.getElementsByClassName("answer_check")[i].setAttribute("value", "false");
    }
    testCheck(elem);
}