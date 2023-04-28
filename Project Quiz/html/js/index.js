nextBtn.addEventListener('click',next);
submitBtn.addEventListener('click',submit);

function beginQuiz() {
    currentQuestion = 0;
    questionText.innerHTML = questions[currentQuestion].question;
    trueBtn.innerHTML = questions[currentQuestion].answers[0].Option;
    trueBtn.onclick = () => {
        let ano=0;
        if(questions[currentQuestion].answers[ano].answer) {
            if (score<3) {
                score++;
            }
        }
        userScore.innerHTML = score;
        if (currentQuestion<2) {
            next();
            
        }

    }

    falseBtn.innerHTML = questions[currentQuestion].answers[1].Option;
    falseBtn.onclick = () => {
        let ano=1;
        if (questions[currentQuestion].answers[ano].answer) {
            if (score<3) {
                score++;
                
            }
            
        }
        userScore.innerHTML = score;
        if (currentQuestion<2) {
            next();
            
        }
    }

    
}

beginQuiz();

function next() {
    currentQuestion++;
    if (currentQuestion>=2) {
        nextBtn.classList.add('hide');

        
    }
    questionText.innerHTML = questions[currentQuestion].question;
    trueBtn.innerHTML = questions[currentQuestion].answers[0].Option;
    trueBtn.onclick = () => {
        let ano = 0;
        if (questions[currentQuestion].answers[ano].answer) {
            if (score<3) {
                score++;
                
            }
            
        }
        userScore.innerHTML = score;
        if (currentQuestion<2) {
            next();
            
        }
    }
    falseBtn.innerHTML = questions[currentQuestion].answers[1].Option;
    falseBtn.onclick = () => {
        let ano = 1;
        if (questions[currentQuestion].answers[ano].answer) {
            if (score<3) {
                score++;
            }
        }
        userScore.innerHTML = score;
        if (currentQuestion<2) {
            next();
        }
    }

    

    
}

function submit() {
    nextBtn.classList.add('hide');
    submitBtn.classList.add('hide');
    trueBtn.classList.add('hide');
    falseBtn.classList.add('hide');
    questionText.innerHTML = "Congratulations!!You have submitted the test";
    
}

