$(document)
    .ready(function () {
        $('.ui.form')
            .form({
                fields: {
                    c1_o2: {
                        identifier: 'c1_o2',
                        rules: [
                            {
                                type: 'regExp[[0-9]{1,3}(\.[0-9]{0,1})?]',
                                prompt: 'Current Oxygen value invalid, please enter a number between 0 - 100'
                            }
                        ]
                    },
                    c2_o2: {
                        identifier: 'c2_o2',
                        rules: [
                            {
                            	type: 'regExp[[0-9]{1,3}(\.[0-9]{0,1})?]',
                                prompt: 'Please enter a number between 0 - 100'
                            }
                        ]
                    },
                    
                    c1_n2: {
                        identifier: 'c1_n2',
                        rules: [
                            {
                            	type: 'regExp[[0-9]{1,3}(\.[0-9]{0,1})?]',
                                prompt: 'Please enter a number between 0 - 100'
                            }
                        ]
                    },
                    
                    c2_n2: {
                        identifier: 'c2_n2',
                        rules: [
                            {
                            	type: 'regExp[[0-9]{1,3}(\.[0-9]{0,1})?]',
                                prompt: 'Please enter a number between 0 - 100'
                            }
                        ]
                    },
                    
                    c1_he: {
                        identifier: 'c1_he',
                        rules: [
                            {
                            	type: 'regExp[[0-9]{1,3}(\.[0-9]{0,1})?]',
                                prompt: 'Please enter a number between 0 - 100'
                            }
                        ]
                    },

                    c2_he: {
                        identifier: 'c2_he',
                        rules: [
                            {
                            	type: 'regExp[[0-9]{1,3}(\.[0-9]{0,1})?]',
                                prompt: 'Please enter a number between 0 - 100'
                            }
                        ]
                    },
                    
                    c1_size: {
                        identifier: 'c2_size',
                        rules: [
                            {
                            	type: 'regExp[(([0-3][0-9]{1,2})|(40)|[0-9])(\.[0-9]{0,1})?]',
                                prompt: 'Please enter a number between 0 - 100'
                            }
                        ]
                    },
                    c2_size: {
                        identifier: 'c2_size',
                        rules: [
                            {
                                type: 'regExp[(([0-3][0-9]{1,2})|(40)|[0-9])(\.[0-9]{0,1})?]',
                                prompt: 'Please enter a number between 0 - 100'
                            }
                        ]
                    }



                }
            })
        ;

    })
;

