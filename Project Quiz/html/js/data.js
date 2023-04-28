const submitBtn = document.getElementById('submit');
const trueBtn = document.getElementById('True');
const falseBtn = document.getElementById('False');
const nextBtn = document.getElementById('next');
const userScore = document.getElementById('user-score');
const questionText = document.getElementById('question-text');


let currentQuestion = 0;
var score = 0;

let questions = [
    {
        question: "Delhi is the capital of India",
        answers:[
            {Option:"Correct", answer:true},
            {Option:"Incorrect", answer:false}

        ]
    },

    {
        question: "Which one of the following is the marvel Hero",
        answers:[
            {Option:"IronMan", answer:true},
            {Option:"Batman", answer:false}
        ]
    },
    {
        question: "Which language is not required for frontend development",
        answers:[
            {Option:"Python", answer:true},
            {Option:"HTML", answer:false}
        ]
    }

]
