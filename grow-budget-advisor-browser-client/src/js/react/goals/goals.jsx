import React from 'react';
import { connect, dispatch } from 'react-redux'


class Goals extends React.Component {

    render() {
        return (
                <div>goals</div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Goals);