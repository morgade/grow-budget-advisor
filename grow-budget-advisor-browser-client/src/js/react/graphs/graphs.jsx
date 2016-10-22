import React from 'react';
import { connect, dispatch } from 'react-redux'

import PageHeader from 'react-bootstrap/lib/PageHeader';

class Goals extends React.Component {
    
    
    render() {
        return (
                <div>
                    <PageHeader>Graphs'n Tips</PageHeader>
                        
                </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Goals);