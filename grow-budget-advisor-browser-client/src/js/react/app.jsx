import React from 'react';

import BudgetNavBar from './navbar/budget-nav-bar.jsx';
import Notification from './notification/notification.jsx';

class App extends React.Component {
    render() {
        return (
            <div>
                <BudgetNavBar />
                <div className="container">
                    {this.props.children}
                </div>
                <Notification />
            </div>
        );
    }
};

export default App;