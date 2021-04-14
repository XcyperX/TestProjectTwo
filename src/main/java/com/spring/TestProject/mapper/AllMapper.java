package com.spring.TestProject.mapper;

import com.spring.TestProject.DTO.AnswerDTO;
import com.spring.TestProject.DTO.FormDTO;
import com.spring.TestProject.DTO.QuestionDTO;
import com.spring.TestProject.DTO.UserDTO;
import com.spring.TestProject.model.Answer;
import com.spring.TestProject.model.Form;
import com.spring.TestProject.model.Question;
import com.spring.TestProject.model.User;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllMapper extends ConfigurableMapper {
    protected void configure(MapperFactory factory) {
        factory.classMap(Form.class, FormDTO.class)
                .field("user.id", "userId")
                .byDefault()
                .customize(new CustomMapper<Form, FormDTO>() {
                    @Override
                    public void mapAtoB(Form form, FormDTO formDTO, MappingContext context) {
                        if (form.getQuestions() != null) {
                            List<Question> questions = new ArrayList<>();
                            List<Answer> answers = new ArrayList<>();
                            form.getQuestions().forEach(question -> {
                                question.getAnswers().forEach(answer -> {
                                    answer.setQuestion(new Question(question.getId()));
                                    answers.add(mapperFacade.map(answer, Answer.class));
                                });
                                question.setAnswers(answers);
                                question.setForm(new Form(form.getId()));
                                questions.add(mapperFacade.map(question, Question.class));
                            });
                            formDTO.setQuestionDTOList(mapperFacade.mapAsList(questions, QuestionDTO.class));
                        }
                        super.mapAtoB(form, formDTO, context);
                    }

                    @Override
                    public void mapBtoA(FormDTO formDTO, Form form, MappingContext context) {
                        if (formDTO.getQuestionDTOList() != null) {
                            List<Question> questions = new ArrayList<>();
                            formDTO.getQuestionDTOList().forEach(questionDTO -> {
                                List<Answer> answers = new ArrayList<>();
                                Question question = new Question();
                                question.setSome(questionDTO.getSome());
                                question.setText(questionDTO.getText());
                                question.setForm(form);
                                answers.clear();
                                questionDTO.getAnswerDTOList().forEach(answerDTO -> {
                                    Answer answer = new Answer();
                                    answer.setQuestion(question);
                                    answer.setChoice(answerDTO.getChoice());
                                    answer.setText(answerDTO.getText());
                                    answers.add(answer);
                                });
//                                question.setAnswers(mapperFacade.mapAsList(questionDTO.getAnswerDTOList(), Answer.class));
                                question.setAnswers(answers);
                                questions.add(question);
                            });
                            form.setQuestions(questions);
                        }
                        super.mapBtoA(formDTO, form, context);
                    }
                })
                .register();

        factory.classMap(User.class, UserDTO.class)
                .byDefault()
                .register();

        factory.classMap(Answer.class, AnswerDTO.class)
                .field("question.id", "questionId")
                .byDefault()
                .register();

        factory.classMap(Question.class, QuestionDTO.class)
                .field("form.id", "formId")
                .byDefault()
                .customize(new CustomMapper<Question, QuestionDTO>() {
                    @Override
                    public void mapAtoB(Question question, QuestionDTO questionDTO, MappingContext context) {
                        if (question.getAnswers() != null) {
                            questionDTO.setAnswerDTOList(mapperFacade.mapAsList(question.getAnswers(), AnswerDTO.class));
                        }
                        super.mapAtoB(question, questionDTO, context);
                    }

                    @Override
                    public void mapBtoA(QuestionDTO questionDTO, Question question, MappingContext context) {
                        if (questionDTO.getAnswerDTOList() != null) {
                            List<Answer> answers = new ArrayList<>();
                            questionDTO.getAnswerDTOList().forEach(answerDTO -> {
                                Answer answer = new Answer();
                                answer.setChoice(answerDTO.getChoice());
                                answer.setText(answerDTO.getText());
                                answer.setQuestion(question);
                                answers.add(answer);
                            });
                            question.setAnswers(answers);
                        }
                        super.mapBtoA(questionDTO, question, context);
                    }
                })
                .register();

    }
}