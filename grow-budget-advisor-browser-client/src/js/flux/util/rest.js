// 3rd party modules
import objectAssign from 'object-assign';
import cookie from 'cookie';

/**
 * TODO: Use better conversion method
 * @param {object} json
 * @returns {String}
 */
function jsonToQueryString(json) {
    return Object.keys(json).map(function(key) {
            return encodeURIComponent(key) + '=' +
                encodeURIComponent(json[key]);
        }).join('&');
}

/**
 * Parses csrf spring token
 * @returns {string}
 */
function getCsrfToken() {
    return cookie.parse(document.cookie)['XSRF-TOKEN'];
}

/**
 * Basic remote fetch methods
 */
class Rest {
    /**
     * Create a promise to post the url
     * @param {string} url
     * @param {object} body
     */
    post(url, body) {
        return fetch(url, {
            method: 'POST',
            credentials: 'same-origin',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': getCsrfToken()
            },
            body: JSON.stringify(body)
        })
        .then(this.assertStatus);
    }
    
    /**
     * Create a promise to post the url/body into a x-www-form-urlencoded format
     * @param {string} url
     * @param {object} body
     */
    postForm(url, body) {
        return fetch(url, {
            method: 'POST',
            credentials: 'same-origin',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'X-CSRF-TOKEN': getCsrfToken()
            },
            body: jsonToQueryString(body)
        })
        .then(this.assertStatus)
        .then(response => response.json());
    }
    
    /**
     * Create a promise to GET the url
     * @param {string} url
     */
    get(url) {
        return fetch(url, {
            method: 'GET',
            credentials: 'same-origin',
            headers: {
                'Accept': 'application/json',
                'X-CSRF-TOKEN': getCsrfToken()
            }
        })
        .then(this.assertStatus)
        .then(response => response.json());
    }
    
    /**
     * Create a promise to send a delete to the url/body into a x-www-form-urlencoded format
     * @param {string} url
     */
    delete(url) {
        return fetch(url, {
            method: 'DELETE',
            credentials: 'same-origin',
            headers: {
                'Accept': 'application/json',
                'X-CSRF-TOKEN': getCsrfToken()
            }
        })
        .then(this.assertStatus);
    }
    
    /**
     * Verify the fetch promise response status
     * @param {object} response
     */
    assertStatus(response) {
        if (response.status >= 200 && response.status < 300) {
            return response;
        } else {
            var error = new Error(`Remote access error (${response.status}) ${response.statusText}`);
            error.response = response;
            throw error;
        }
    }
}

export default new Rest();