import { Routes, Route } from 'react-router-dom';

import { AuthProvider } from './contexts/AuthContext';
import { OfferProvider } from './contexts/OfferContext';

import { Header } from "./components/Header/Header";
import { Home } from "./components/Home/Home";
import { Login } from './components/Login/Login';
import { Register } from './components/Register/Register';
import { Logout } from './components/Logout/Logout';
import { SchoolList } from './components/SchoolList/SchoolList';
import { SchoolDetails } from './components/SchoolDetails/SchoolDetails';
import { AddOffer } from './components/AddOffer/AddOffer';
import { OfferList } from './components/OfferList/OfferList';
import { OfferDetails } from './components/OfferDetails/OfferDetails';
import { EdithOffer } from './components/EditOffer/EditOffer';

function App() {

  return (
    <AuthProvider>
		<OfferProvider>
			<Header />
				<Routes>
					<Route path="/" element={<Home />} />
					<Route path='/login' element={<Login />} />
					<Route path='/logout' element={<Logout />} />
					<Route path='/register' element={<Register />} />
					<Route path='/schools/all' element={<SchoolList />} />
					<Route path='/schools/:schoolId' element={<SchoolDetails />} />
					<Route path='/offers/add' element={<AddOffer />} />
					<Route path='/offers/all' element={<OfferList />} />
					<Route path='/offers/:offerId' element={<OfferDetails />} />
					<Route path='/offers/:offerId/edit' element={<EdithOffer />} />

				</Routes>
		</OfferProvider>
    </AuthProvider>
  );
}

export default App;
