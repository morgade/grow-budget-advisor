/* global fetch */
// TODO: Use better conversion method
function jsonToQueryString(json) {
    return Object.keys(json).map(function(key) {
            return encodeURIComponent(key) + '=' +
                encodeURIComponent(json[key]);
        }).join('&');
}

class Rest {
    post(url, body) {
        return fetch(url, {
            method: 'POST',
            credentials: 'same-origin',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        })
        .then(this.assertStatus);
    }
    
    postForm(url, body) {
        return fetch(url, {
            method: 'POST',
            credentials: 'same-origin',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: jsonToQueryString(body)
        })
        .then(this.assertStatus)
        .then(response => response.json());
    }
    
    get(url) {
        return fetch(url, {
            method: 'GET',
            credentials: 'same-origin',
            headers: {
                'Accept': 'application/json'
            }
        })
        .then(this.assertStatus)
        .then(response => response.json());
    }
    
    delete(url) {
        return fetch(url, {
            method: 'DELETE',
            credentials: 'same-origin',
            headers: {
                'Accept': 'application/json'
            }
        })
        .then(this.assertStatus);
    }
    
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