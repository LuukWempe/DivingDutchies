$(document)
    .ready(function () {
        $('.ui.form')
            .form({
                fields: {
                    c1_o2: {
                        identifier: 'c1_o2',
                        rules: [
                            {
                                type: 'integer[0..100]',
                                prompt: 'Please enter a number between 0 - 100'
                            }
                        ]
                    },
                    c2_o2: {
                        identifier: 'c2_o2',
                        rules: [
                            {
                                type: 'integer[0..100]',
                                prompt: 'Please enter a number between 0 - 100'
                            }
                        ]
                    }

                }
            })
        ;

    })
;