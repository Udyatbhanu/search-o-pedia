package com.slack.search.ui.usersearch

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.slack.search.R
import com.slack.search.core.framework.BaseFragment
import com.slack.search.model.UserSearchResult
import timber.log.Timber
import javax.inject.Inject

import kotlinx.android.synthetic.main.fragment_user_search.*


/**
 * Main fragment displaying and handling interactions with the view.
 * We use the MVP pattern and attach a Presenter that will be in charge of non view related operations.
 */
class UserSearchFragment : BaseFragment(), UserSearchContract.View {


    @Inject
    internal lateinit var presenter: UserSearchPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_user_search, container, false)

        setHasOptionsMenu(true)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolbar()

        val horizontalDecoration = DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL)
        val horizontalDivider = ContextCompat.getDrawable(activity!!, R.drawable.horizontal_divider)
        horizontalDecoration.setDrawable(horizontalDivider!!)


        setUpList(horizontalDecoration)
    }

    override fun onStart() {
        super.onStart()

        presenter.attach(this)
    }

    override fun onStop() {
        super.onStop()

        presenter.detach()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_user_search, menu)

        val searchView: SearchView = menu.findItem(R.id.search_menu_item).actionView as SearchView
        searchView.queryHint = getString(R.string.search_users_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                presenter.onQueryTextChange(newText)
                return true
            }
        })
    }

    override fun onUserSearchResults(results: Set<UserSearchResult>) {
        val adapter = user_search_result_list.adapter as UserSearchAdapter
        adapter.setResults(results)
    }

    override fun onUserSearchError(error: Throwable) {
        Timber.e(error, "Error searching users.")
    }

    private fun setUpToolbar() {
        val act = activity as UserSearchActivity
        act.setSupportActionBar(toolbar)
    }

    private fun setUpList(horizontalDecoration: DividerItemDecoration) {




        with(user_search_result_list) {
            adapter = UserSearchAdapter()
            layoutManager = LinearLayoutManager(activity).apply {
                orientation = LinearLayoutManager.VERTICAL
            }

            addItemDecoration(horizontalDecoration)
            setHasFixedSize(true)
        }
    }
}