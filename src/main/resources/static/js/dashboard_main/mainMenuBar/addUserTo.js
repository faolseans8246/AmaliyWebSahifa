/* Part 1 */
/*The following code uses the validationSpec object to enforce its rules.  Since I would outsource this work to
* a library typically, I'm not sure if I should be using other options like HTML5 validation,
* though I'm under the impression that runs into cross browser support issues.  I know that to make use of those I would decorate the input
* tags with the appropriate fields (required, placeholder, value) and to specifically turn it off use novalidate
*
* For additional usability the form uses a 'keydown' event handler for live validation that's triggered
* whenever the user has stopped typing for 500 ms.  If the user blurs the field before then, validation is immediate.
* Invalid / Valid input adds a corresponding class to the input field, which provides a
* red or green colored border as a visual cue to the user.  If the form is invalid then the error message
* is plucked from validationSpec and inserted into the appropriate div.error tag.
* The submit button is currently suppressed using e.preventDefault, but I put in some
* code to check for missing fields when it's clicked.
*
* The styling is mimicked from cPanel's own site with the thought that elements should be cohesive
* and adhere to a styleguide.
*
* */

(function() {
    var validationSpec = {
        username: {
            required: true,
            pattern: /^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])[a-zA-Z0-9]+$/,
            error: "Username must include 1 or more lower case, upper case, and number.  May not contain special characters."
        },
        password: {
            required: true,
            pattern: /^(?=(.*\d){2,})[\w]{8,15}$/,
            error: 'Password must be between 8 and 15 characters and include 2 or more digits.'
        },
        usernumber: {
            required: true,
            pattern: /^[\d]{36}$/,
            error: 'usernumber may contain only numbers and must be 36 digits long.'
        },
        geoglocation: {
            required: false,
            pattern: /.*/
        }
    };
    var form = document.querySelector('form');
    var validateAfterPause;
    var clearValidationTimer = function() {
        if (validateAfterPause != 'undefined') {clearTimeout(validateAfterPause);}
    };
    form.addEventListener('keydown', function(e) {
        clearValidationTimer();
        if (!validationSpec[e.target.id]) return; //if the input isn't in our validation spec then don't attempt to validate
        validateAfterPause = setTimeout(function() {validate(e.target);}, 500);
    });

    var validate = function(inputEl) {
        var pattern = validationSpec[inputEl.id].pattern;
        var isValid = pattern.test(inputEl.value);
        var classList = inputEl.classList;
        var errorEl = document.querySelector('#' + inputEl.id + 'Error');

        if (isValid) {
            classList.remove('invalid');
            classList.add('valid');
            if (errorEl) {errorEl.style.display = 'none';}
        } else {
            classList.remove('valid');
            classList.add('invalid');
            errorEl.innerHTML = validationSpec[inputEl.id].error;
            errorEl.style.display = 'block';
        }
    };

    var handleBlur = function(e) {
        var target = e.target;

        //event delegation will fire blur for all form inputs including those not in our validationSpec
        //we check upfront to see if we have a spec and want to continue.  If not, we return immediately.
        if (!validationSpec[target.id]) return; //if the input isn't in our validation spec then don't attempt to validate

        var spec = validationSpec[target.id];
        var isRequired = spec.required || false;

        if (isRequired && target.value === '') {
            clearValidationTimer(); // if user tabbed out, then keypress event would also be calling validateAfterPause
        } else {
            clearValidationTimer(); // if user blurred with input we'll validate immediately instead
            validate(e.target);
        }
    };
    form.addEventListener('blur', handleBlur, true); //form events don't bubble so to use event delegation they require capturing.  This still suffers compatibility with older IE which does not support capturing.
    form.addEventListener('focusout', handleBlur); // same thing but for IE

    form.addEventListener('submit', function(e) {
        e.preventDefault();
        for (var idname in validationSpec) {
            if (!validationSpec.hasOwnProperty(idname)) continue; //skip non own properties immediately
            var spec = validationSpec[idname];
            var target = document.querySelector('#' + idname);
            var errorEl =document.querySelector('#' + idname + 'Error');

            if (target.classList.contains('valid')) continue; // if it's valid skip to next item in loop
            if (!errorEl) continue; //if there's no div for the error message, then skip to next item in loop

            if (spec.required && target.value === '') {
                errorEl.innerHTML = 'Required field is missing';
                errorEl.style.display = 'block';
            } else {
                errorEl.innerHTML = validationSpec[target.id].error;
                errorEl.style.display = 'block';
            }
        }
    });
})();