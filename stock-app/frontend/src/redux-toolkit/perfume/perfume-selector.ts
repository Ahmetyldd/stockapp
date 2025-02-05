import { FullProductResponse, LoadingStatus, ReviewResponse } from "../../types/types";
import { RootState } from "../../store";
import { ProductState } from "./perfume-slice";

export const selectProductState = (state: RootState): ProductState => state.perfume;
export const selectProduct = (state: RootState): Partial<FullProductResponse> => state.perfume.perfume;
export const selectReviews = (state: RootState): Array<ReviewResponse> => state.perfume.reviews;
export const selectProductErrorMessage = (state: RootState): string => state.perfume.errorMessage;

export const selectLoadingStatus = (state: RootState): LoadingStatus => selectProductState(state).loadingState;
export const selectIsProductLoading = (state: RootState): boolean => selectLoadingStatus(state) === LoadingStatus.LOADING;
export const selectIsProductLoaded = (state: RootState): boolean => selectLoadingStatus(state) === LoadingStatus.LOADED;
export const selectProductError = (state: RootState): boolean => selectLoadingStatus(state) === LoadingStatus.ERROR;
