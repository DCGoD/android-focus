var exec = require('cordova/exec');

exports.getFocus = function(arg0, success, error) {
  exec(success, error, 'AndroidFocus', 'getFocus', [arg0]);
};