var exec = require('cordova/exec');

var NoSleepPlugin = {
    activate: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'NoSleepPlugin', 'activate', []);
    },

    deactivate: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'NoSleepPlugin', 'deactivate', []);
    }
};

module.exports = NoSleepPlugin;
