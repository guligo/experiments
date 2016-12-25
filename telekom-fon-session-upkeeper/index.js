require('console-stamp')(console, 'HH:MM:ss');
require('fs').readFile('config.json', 'utf8', function(error, content) {

    // config
    const config = JSON.parse(content);

    // constants
    const PAUSE_BEFORE_AUTH = 60000;
    const PAUSE_AFTER_AUTH = 30000;
    const PAUSE_AFTER_SUCCESS = 15000;
    const PAUSE_AFTER_ERROR = 15000;
    const PAUSE_AFTER_RSSI = 60000;

    const TARGET = config.target;
    const USERNAME = config.username;
    const PASSWORD = config.password;

    // headless browser
    const Browser = require('zombie');
    Browser.localhost('*', 3000);
    const browser = new Browser();

    // misc
    const sleep = require('sleep');
    const colors = require('colors/safe');
    const scanner = require('node-wifi-scanner');

    var upkeepSession = function() {
        var pageLoadStartTime = Date.now();
        browser
            .fetch(TARGET)
            .then(function(response) {
                if (isLoginPortal(response)) {
                    browser
                        .visit(response.request.url, function() {
                            var pageLoadEndTime = Date.now();
                            var pageLoadTime = (pageLoadEndTime - pageLoadStartTime) / 1000;
                            console.log(colors.yellow('Login portal was hit, loading time = [' + pageLoadTime + 's]'));

                            setTimeout(authenticateSession, PAUSE_BEFORE_AUTH);
                        })
                } else {
                    var pageLoadEndTime = Date.now();
                    var pageLoadTime = (pageLoadEndTime - pageLoadStartTime) / 1000;
                    console.log(colors.green('Session ongoing! Loading time of test web page = [' + pageLoadTime + 's]'));

                    setTimeout(upkeepSession, PAUSE_AFTER_SUCCESS);
                }
            })
            .catch(handleError);
    }

    var isLoginPortal = function(response) {
        return response.request.url.indexOf('telekom.portal.fon.com') > -1;
    }

    var authenticateSession = function() {
        try {
            browser.fill('username', USERNAME);
            browser.fill('password', PASSWORD);

            // just making sure that certain libs have been loaded on authentication page
            browser.evaluate("jQuery('#username').val()");

            browser.clickLink('Verbindung herstellen', function() {
                console.log(colors.yellow('Authentication completed'));

                setTimeout(upkeepSession, PAUSE_AFTER_AUTH);
            });
        } catch (error) {
            handleError(error);
        }
    }

    var checkSignalStrength = function(predicate) {
        scanner.scan((err, networks) => {
            for (i = 0; i < networks.length; i++) {
                var network = networks[i];
                if (network.ssid === 'Telekom_FON') {
                    var msg = 'Signal strength of AP with MAC [' + network.mac + '] is [' + network.rssi + ' dBm]';
                    logSignalStrength(network.rssi, msg);
                }
            }
            return;
        });
    }

    var logSignalStrength = function(rssi, msg) {
        if (rssi > -80) {
            console.log(colors.green(msg));
        } else if (rssi > -90) {
            console.log(colors.yellow(msg));
        } else {
            console.log(colors.red(msg));
        }
    }

    var handleError = function(error) {
        console.log(colors.red('Connection error occurred'));
        console.log(error);

        setTimeout(upkeepSession, PAUSE_AFTER_ERROR);
    }

    setInterval(checkSignalStrength, PAUSE_AFTER_RSSI);
    upkeepSession();

});
