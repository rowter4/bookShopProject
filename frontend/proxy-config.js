module.exports = [
    {
      context: [ '/authenticate/**' ],
      target: 'http://localhost:8080',
      secure: false
    },

    {
      context: [ '/upload/**' ],
      target: 'http://localhost:8080',
      secure: false
    },

    {
      context: [ '/book-summary/**' ],
      target: 'http://localhost:8080',
      secure: false
    },

    {
      context: [ '/book-detail/**' ],
      target: 'http://localhost:8080',
      secure: false
    },

    {
      context: [ '/submit-order/**' ],
      target: 'http://localhost:8080',
      secure: false
    },

    {
      context: [ '/pastorders/**' ],
      target: 'http://localhost:8080',
      secure: false
    },

    {
      context: [ '/pastorderdetail/**' ],
      target: 'http://localhost:8080',
      secure: false
    }

  ]